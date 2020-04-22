 import groovy.json.JsonBuilder
import groovy.json.JsonSlurperClassic
 
def writeJSONFile(fileName, json) {
	String output = toJson(json)
	echo fileName
	echo output
	//echo 'writing resource '+fileName+': \n' + output
	writeFile file: fileName, text: output
}

def toJson(obj){
	def builder = new JsonBuilder(obj)
	String output = builder.toPrettyString()
	return output
}
