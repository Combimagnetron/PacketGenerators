import cz.lukynka.prettylog.LogType
import cz.lukynka.prettylog.log
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@OptIn(ExperimentalSerializationApi::class)
class WikiVGDataGenerator(packet: List<String>, overrides: List<Override>) {

    var packets: List<Packet> = mutableListOf()
    var json: String = ""

    init {
        log("Starting wiki.vg data generator", LogType.DEBUG)
        val htmlContentGetter = HTMLContentGetter()
        val htmlParser = HTMLParser(htmlContentGetter.html, overrides)
        packets = htmlParser.parseToPackets(packet)

        val pretty = Json {
            prettyPrint = true
            prettyPrintIndent = "    "
        }
        json = pretty.encodeToString<List<Packet>>(packets)
    }
}