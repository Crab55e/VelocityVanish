package ir.syrent.velocityvanish.utils

import com.cryptomorin.xseries.XSound
import ir.syrent.velocityvanish.ruom.adventure.AdventureApi
import ir.syrent.velocityvanish.storage.Message
import ir.syrent.velocityvanish.storage.Settings
import net.kyori.adventure.inventory.Book
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

fun CommandSender.sendMessage(message: Message, vararg replacements: TextReplacement) {
    AdventureApi.get().sender(this).sendMessage(Settings.formatMessage(message, *replacements).component())
}

fun Player.sendMessage(message: Message, vararg replacements: TextReplacement) {
    this.playSound(this.location, XSound.ENTITY_EXPERIENCE_ORB_PICKUP.parseSound()!!, 1f, 1f)
    AdventureApi.get().sender(this).sendMessage(Settings.formatMessage(message, *replacements).component())
}

fun Player.sendActionbar(message: Message, vararg replacements: TextReplacement) {
    AdventureApi.get().sender(this).sendActionBar(Settings.formatMessage(message, *replacements).component())
}

fun Player.openBook(book: Book) {
    this.playSound(this.location, XSound.ITEM_BOOK_PAGE_TURN.parseSound()!!, 1f, 1f)
    AdventureApi.get().sender(this).openBook(book)
}