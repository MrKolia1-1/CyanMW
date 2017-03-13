package me.xjcyan1de.cyanmw;

import net.minecraft.server.v1_11_R1.NBTTagCompound;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public class SpawnEgg {

    public static ItemStack get(EntityType type, int amount) {


        ItemStack item = new ItemStack(Material.MONSTER_EGG, amount);
        net.minecraft.server.v1_11_R1.ItemStack stack = CraftItemStack.asNMSCopy(item);
        NBTTagCompound tagCompound = stack.getTag();
        if (tagCompound == null)

        {
            tagCompound = new NBTTagCompound();
        }

        NBTTagCompound id = new NBTTagCompound();
        id.setString("id", type.name());
        tagCompound.set("EntityTag", id);
        stack.setTag(tagCompound);
        return CraftItemStack.asBukkitCopy(stack);
    }
}