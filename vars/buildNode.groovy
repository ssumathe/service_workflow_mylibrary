def call(body) {
def config = [:]
body.resolve.Strategy=Clousure.DELEGATE_FIRST
body.delegate= config
body()
def folder ="my folder in build groovy file"
stage("Application build") {
config.buildCommands
}
}