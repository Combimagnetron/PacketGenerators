import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Override(
    @SerialName("packet_name")
    val packetName: String,
    @SerialName("packet_state")
    val packetState: String,
    val override: List<PacketField>
)