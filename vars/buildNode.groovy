def call(body) {
def config = [:]
body.resolve.Strategy=Clousure.DELEGATE_FIRST
body.delegate= config
body()
  node {
def folder ="my folder in build groovy file"
def buildCommands = config.buildC
  buildJava(buildCommands)
}
}
def buildJava(buildCommands) {
  stage("Application build") {
config.buildCommands
}
}
