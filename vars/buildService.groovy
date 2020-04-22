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
    writeJSONFile("service.json", json)
    echo "Wrote file "+"service.json"
	sh "hostname"
	sh "ls -l"
	return 'service.json'
}
    def writeJSONFile(filename, json) {
        def builder = new JsonBuilder(json)
        String output = builder.toPrettyString()
	echo 'writing resource '+'service.json+': \n' + output
	writeFile file: fileName, text: output
    

}
