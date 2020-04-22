import groovy.json.JsonBuilder
import groovy.json.JsonSlurperClassic
def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    def folderName = "MyFolderWorking"
    println "folderName: " + folderName
    
    def json = new JsonSlurperClassic().parseText(
    """
    node() 
    {
    	  "apiVersion": "v1",
    	  "kind": "Service",
    	  "metadata": {
    	    "name": "deployName",
    	    "namespace": "ns1",
    	    "annotations": {
    	        "prometheus.io/scrape": "true",
    	        "prometheus.io/path": "/prometheus"
    	    },
    	    "labels": {
    	      "context": "/",
    	      "hystrix.cluster": "default"
    	    }
    	  },
    	  "spec": {
    	    "ports": [
    	      {
    	    	"name": "http",
    	        "port": 8080,
    	        "targetPort": 8080
    	      }
    	    ],
    	    "selector": {
    	      "app": "myservice"
    	    }
    	  }
    	}
        """
        )
	def fileName = 'dev' + "-service.json"
    common.writeJSONFile(fileName, json)
    echo "Wrote file "+"service.json"
	sh "hostname"
	sh "ls -l"
	return 'service.json'
}
   
}
