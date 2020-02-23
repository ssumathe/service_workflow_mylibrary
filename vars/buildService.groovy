def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    node {
    def folderName = common.getFolder()
    def buildCommands = config.buildCommands
    println "folderName: " + folderName
    println "buildCommand is " + buildCommands

    buildNode {
        buildC = buildCommands
        }
}  
}
