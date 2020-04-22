 import groovy.json.JsonBuilder
 
 def writeJSONFile(fileName, json) {
        def builder = new JsonBuilder(json)
        String output = builder.toPrettyString()
	echo output
	echo fileName 
	//echo 'writing resource '+'service.json' + ':' '\n' + output
	writeFile file: fileName, text: output
    
}
