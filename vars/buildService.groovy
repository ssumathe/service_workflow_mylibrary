import groovy.json.JsonSlurperClassic
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
    	  "kind": "Service"
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
