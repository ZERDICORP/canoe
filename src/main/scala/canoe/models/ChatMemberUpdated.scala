package canoe.models

import io.circe.Decoder
import io.circe.generic.semiauto.deriveDecoder

final case class ChatMemberUpdated(
    chat: Chat,
    from: User,
    date: Long,
    oldChatMember: ChatMember,
    newChatMember: ChatMember
)

object ChatMemberUpdated {
  implicit val dec: Decoder[ChatMemberUpdated] = deriveDecoder
}
