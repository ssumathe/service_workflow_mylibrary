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
    	    "name": "${deployName}",
    	    "namespace": "${config.namespace}",
    	    "annotations": {
    	        "prometheus.io/scrape": "true",
    	        "prometheus.io/path": "${externalContextPath}/prometheus"
    	    },
    	    "labels": {
    	      "context": "${config.context}",
    	      "hystrix.enabled": "${isHystrixEnabled}",
    	      "hystrix.cluster": "default"
    	    }
    	  },
    	  "spec": {
    	    "ports": [
    	      {
    	    	"name": "http",
    	        "port": 8080,
    	        "targetPort": ${appPort}
    	      }
    	    ],
    	    "selector": {
    	      "app": "${deployName}"
    	    }
    	  }
    	}
}
