def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    def folderName = "MyFolderWorking"
    println "folderName: " + folderName
}
