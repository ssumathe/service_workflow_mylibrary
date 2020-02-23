def call(body) {
def config = [:]
body.resolve.Strategy=Clousure.DELEGATE_FIRST
body.delegate= config
body()
def folder ="my folder in build groovy file"
def buildCommands = config.buildCommands 
}
def buildJava(config.buildCommands) {
  stage("Application build") {
config.buildCommands
}
}
