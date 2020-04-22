import groovy.json.JsonSlurperClassic
import groovy.json.JsonBuilder
def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    def folderName = "MyFolderWorking"
    println "folderName: " + folderName
     node("windows") 
	{
    
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
	

	def fileName = 'dev' + "-service.json"
		
    writeJSONFile(fileName, json)
    echo "Wrote file "+"service.json"
		echo 'end'
	return 'service.json'
}
}
	def writeJSONFile(fileName, json) {
	String output = toJson(json)
	echo fileName
	echo output
	//echo 'writing resource '+fileName+': \n' + output
	writeFile file: fileName, text: output
}

def toJson(obj){
	def builder = new JsonBuilder(obj)
	String output = builder.toPrettyString()
	return output
}
// for linux
		//sh "hostname"
	//sh "ls -l"
	//sh "kubectl apply ."
