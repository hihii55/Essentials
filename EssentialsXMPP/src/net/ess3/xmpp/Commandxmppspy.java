package net.ess3.xmpp;

import net.ess3.commands.EssentialsCommand;
import net.ess3.commands.NotEnoughArgumentsException;
import java.util.List;

import org.bukkit.entity.Player;


public class Commandxmppspy extends EssentialsCommand
{
	@Override
	protected void run(final CommandSender sender, final String commandLabel, final String[] args) throws NotEnoughArgumentsException
	{
		if (args.length < 1)
		{
			throw new NotEnoughArgumentsException();
		}

		final List<Player> matches = server.matchPlayer(args[0]);

		if (matches.isEmpty())
		{
			sender.sendMessage("§cThere are no players matching that name.");
		}

		for (Player p : matches)
		{
			try
			{
				final boolean toggle = EssentialsXMPP.getInstance().toggleSpy(p);
				sender.sendMessage("XMPP Spy " + (toggle ? "enabled" : "disabled") + " for " + p.getDisplayName());
			}
			catch (Exception ex)
			{
				sender.sendMessage("Error: " + ex.getMessage());
			}
		}
	}
}
