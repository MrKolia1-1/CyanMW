package me.xjcyan1de.cyanmw;

import net.minecraft.server.v1_11_R1.BlockPosition;
import net.minecraft.server.v1_11_R1.NBTTagCompound;
import net.minecraft.server.v1_11_R1.TileEntityStructure;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_11_R1.CraftWorld;

class StructureBlock {

    static void paste(String name, World world, int x, int y, int z, int posX, int posY, int posZ) {

        Block block = world.getBlockAt(x, y, z);
        block.setType(Material.STRUCTURE_BLOCK, false);
        BlockPosition pos = new BlockPosition(block.getX(), block.getY(), block.getZ());
        TileEntityStructure structure = (TileEntityStructure)((CraftWorld)world).getHandle().getTileEntity(pos);
        structure.a(createNBTstructure(name, x, y, z, posX, posY, posZ));
        world.getBlockAt(x, y+1, z).setType(Material.REDSTONE_BLOCK);

    }

    private static NBTTagCompound createNBTstructure(String name, int x, int y, int z, int posX, int posY, int posZ) {
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
        nbttagcompound.setBoolean("powered", false);
        nbttagcompound.setBoolean("showair", false);
        nbttagcompound.setBoolean("showboundingbox", true);
        nbttagcompound.setFloat("integrity", 1.0f);
        nbttagcompound.setLong("seed", 0);
        return nbttagcompound;
    }
}