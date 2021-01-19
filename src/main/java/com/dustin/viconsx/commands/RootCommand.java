package com.dustin.viconsx.commands;

import com.dustin.viconsx.utils.VCommand;
import com.dustin.viconsx.utils.VFormatter;
import com.dustin.viconsx.utils.configs.Configurations;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class RootCommand extends VCommand {

    public RootCommand(String command) {
        super(command);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lavel, String[] args) {

        final int argLength = args.length;

        switch (argLength) {
            case 1:

                if ("reload".equals(args[0])) {
                    Configurations.get().updateAll();
                    sender.sendMessage("§aReload successfully!");
                }

                if ( "get".equals(args[0])) {
                    final String name = VFormatter.colorize(Configurations.get().get("config").getString("name"));
                    sender.sendMessage("§cFuck you "+name);
                }

                break;
            case 2:
                break;
            default:
                break;
        }

        return true;
    }
}
