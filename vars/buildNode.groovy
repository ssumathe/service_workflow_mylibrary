def call(body) {
def config = [:]
body.resolveStrategy = Closure.DELEGATE_FIRST
body.delegate= config
body()
def folder ="my folder in build groovy file"
def buildCommands = config.buildC
 println "buildCommands" + buildCommands
  buildJava(buildCommands)
}
def buildJava(buildCommands) {
  stage("Application build") {
config.buildCommands
}
}
