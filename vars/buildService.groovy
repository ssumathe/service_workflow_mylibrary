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
    @NonCPS
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
// for linux
		//sh "hostname"
	//sh "ls -l"
	return 'service.json'
}
}
