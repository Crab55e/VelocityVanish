package ir.sayandevelopment.command;

import com.velocitypowered.api.command.SimpleCommand;
import com.velocitypowered.api.proxy.Player;
import ir.sayandevelopment.VelocityMain;
import ir.sayandevelopment.utils.CommonUtils;
import net.kyori.adventure.text.minimessage.MiniMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class FindCommand implements SimpleCommand {

    @Override
    public void execute(Invocation invocation) {
        Player player = (Player) invocation.source();
        String[] args = invocation.arguments();
        MiniMessage miniMessage = MiniMessage.miniMessage();

        if (args.length == 1) {
            boolean find = false;
            for (Player player1 : VelocityMain.INSTANCE.getServer().getAllPlayers()) {
                if (player1.getUsername().equalsIgnoreCase(args[0])) {
                    if (!CommonUtils.isPlayerVanished(player1) || player.hasPermission("sayanvanish.find.bypass")) {
                        player.sendMessage(miniMessage.deserialize(String.format(VelocityMain.PROXY_PREFIX +
                                        "<color:#F8BD04>%s <color:#C1D6F1>is playing in <color:#F8BD04>%s",
                                player1.getUsername(), player1.getCurrentServer().get().getServerInfo().getName()
                        )));
                        find = true;
                    }
                }
            }
            if (!find) {
                player.sendMessage(miniMessage.deserialize(VelocityMain.PROXY_PREFIX + "<color:#ff6a00>Player not found!"));
            }
        } else {
            player.sendMessage(miniMessage.deserialize(VelocityMain.PROXY_PREFIX + "<color:#ff6a00>Usage: /find <player>"));
        }
    }

    @Override
    public List<String> suggest(Invocation invocation) {
        if (invocation.arguments().length == 1) {
            return VelocityMain.INSTANCE.getServer().getAllPlayers().stream()
                    .filter(player -> !VanishCommand.vanishedPlayers.containsKey(player.getUniqueId()))
                    .map(Player::getUsername).collect(Collectors.toList());
        }
        return SimpleCommand.super.suggest(invocation);
    }

    @Override
    public CompletableFuture<List<String>> suggestAsync(Invocation invocation) {
        CompletableFuture<List<String>> completableFuture = new CompletableFuture<>();

        if (invocation.arguments().length == 1) {
            completableFuture.complete(VelocityMain.INSTANCE.getServer().getAllPlayers().stream()
                    .filter(player -> !VanishCommand.vanishedPlayers.containsKey(player.getUniqueId()))
                    .map(Player::getUsername).collect(Collectors.toList()));
        }
        return completableFuture;
    }
}
