def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    node {
       // def branch = ${env.BRANCH_NAME}
    def buildCommands = config.buildCommands
   envconfig =  env.getEnvironment()
        
     println branch
    println "branch: " + branch
    println "buildCommand is " + buildCommands

    buildNode {
        buildC = buildCommands
        }
}  
}
