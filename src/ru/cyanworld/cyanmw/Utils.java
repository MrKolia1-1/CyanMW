package ru.cyanworld.cyanmw;

import net.minecraft.server.v1_11_R1.BlockPosition;
import net.minecraft.server.v1_11_R1.NBTTagCompound;
import net.minecraft.server.v1_11_R1.TileEntityStructure;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_11_R1.CraftWorld;
import org.bukkit.entity.Player;

public class Utils {
    private final Main main;

    Utils(Main main) {
        this.main = main;
    }

    public void pasteStructure(String name, World world, int x, int y, int z, int posX, int posY, int posZ) {

        Block block = world.getBlockAt(x, y, z);

        block.setType(Material.STRUCTURE_BLOCK);
        BlockPosition pos = new BlockPosition(block.getX(), block.getY(), block.getZ());
        TileEntityStructure structure = (TileEntityStructure) ((CraftWorld) world).getHandle().getTileEntity(pos);
        structure.a(loadStructure(name, x, y, z, posX, posY, posZ));
        structure.update();
    }

    private static NBTTagCompound loadStructure(String name, int x, int y, int z, int posX, int posY, int posZ) {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        nbttagcompound.setString("id", "Structure");
        nbttagcompound.setInt("x", x);
        nbttagcompound.setInt("y", y);
        nbttagcompound.setInt("z", z);
        nbttagcompound.setString("name", name);
        nbttagcompound.setString("author", "XjCyan1de");
        nbttagcompound.setString("metadata", "");
        nbttagcompound.setInt("posX", posX);
        nbttagcompound.setInt("posY", posY);
        nbttagcompound.setInt("posZ", posZ);
        nbttagcompound.setString("rotation", "NONE");
        nbttagcompound.setString("mirror", "NONE");
        nbttagcompound.setString("mode", "LOAD");
        nbttagcompound.setByte("ignoreEntities", (byte) 1);
        nbttagcompound.setBoolean("powered", true);
        nbttagcompound.setBoolean("showair", false);
        nbttagcompound.setBoolean("showboundingbox", true);
        nbttagcompound.setFloat("integrity", 1.0f);
        nbttagcompound.setLong("seed", 0);
        return nbttagcompound;
    }

    public void giveItem(String name, Player player) {
        switch (name) {
            case "bow":
                player.getInventory().addItem(main.items.bow);
                break;
            case "green_chestplate":
                player.getInventory().addItem(main.items.green_chestplate);
                break;
            case "red_chestplate":
                player.getInventory().addItem(main.items.red_chestplate);
                break;
            case "green_leggings":
                player.getInventory().addItem(main.items.green_leggings);
                break;
            case "red_leggings":
                player.getInventory().addItem(main.items.red_leggings);
                break;
            case "green_boots":
                player.getInventory().addItem(main.items.green_boots);
                break;
            case "red_boots":
                player.getInventory().addItem(main.items.red_boots);
                break;
            default:
                player.sendMessage("Не известный предмет");
                break;
        }
    }
}
