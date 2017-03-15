package ru.cyanworld.cyanmw;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Missiles implements Listener {
    private final Main main;
    private final Server server;

    Missiles(Main main) {
        this.main = main;
        this.server = main.server;
        server.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void HoeClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player player = event.getPlayer();
            ItemStack item = player.getInventory().getItemInMainHand();
            if (item.getType() != Material.GOLD_HOE)
                return;
            if (item.hasItemMeta()) {
                Block block = event.getClickedBlock();
                World world = block.getWorld();
                int x = block.getX();
                int y = block.getY();
                int z = block.getZ();
                switch (item.getItemMeta().getDisplayName()) {
                    case "§aЗелёный страж":
                        main.utils.pasteStructure("GreenGuardian", world, x, y + 1, z, -1, -5, -10);
                        break;
                    case "§cКрасный страж":
                        main.utils.pasteStructure("RedGuardian", world, x, y + 1, z, -1, -5, 3);
                        break;
                    case "§aЗелёная молния":
                        main.utils.pasteStructure("GreenLightning", world, x, y + 1, z, -1, -5, -12);
                        break;
                    case "§cКрасная молния":
                        main.utils.pasteStructure("RedLightning", world, x, y + 1, z, -1, -5, 4);
                        break;
                    case "§aЗелёный Джаггернаут":
                        main.utils.pasteStructure("GreenJuggernaut", world, x, y + 1, z, -1, -6, -13);
                        break;
                    case "§cКрасный Джаггернаут":
                        main.utils.pasteStructure("RedJuggernaut", world, x, y + 1, z, -1, -6, 3);
                        break;
                    case "§aЗелёный противобарьер":
                        main.utils.pasteStructure("GreenShieldbuster", world, x, y + 1, z, -1, -6, -17);
                        break;
                    case "§cКрасный противобарьер":
                        main.utils.pasteStructure("RedShieldbuster", world, x, y + 1, z, -1, -6, 3);
                        break;
                    case "§aЗелёный томагавк":
                        main.utils.pasteStructure("GreenTomahawk", world, x, y + 1, z, -1, -5, -15);
                        break;
                    case "§cКрасный томагавк":
                        main.utils.pasteStructure("RedTomahawk", world, x, y + 1, z, 0, -5, 3);
                        break;
                    default: //Do something
                }
                player.getInventory().setItemInMainHand(main.items.air);
            }
        }
    }
}
