
def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    def folderName = "MyFolder"
    def buildCommands = config.buildCommands
    println "folderName: " + folderName
    buildNode(buildCommands)
    }
    def buildNode(buildCommands){
        
    stage('Application Build') {
    
    sh "${buildCommands}"
    
    println "InSide buildNode"
    }
    }