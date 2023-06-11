package dev.rexbluefox.types;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.Collection;
import java.util.List;

public class TemplateBlock implements org.bukkit.block.Block {
    private Location location;
    private Material type;
    private BlockState state;

    public TemplateBlock(Location location,Material type){
        this.location = location;
        this.type = type;
    }
    public TemplateBlock(World world,int x,int y,int z, Material type, BlockState state){
        this.location = new Location(world,x,y,z);
        this.type = type;
        this.state = state;
    }
    @Deprecated
    public byte getData() {
        return 0;
    }


    public org.bukkit.block.Block getRelative(int i, int i1, int i2) {
        return null;
    }


    public org.bukkit.block.Block getRelative(BlockFace blockFace) {
        return null;
    }


    public org.bukkit.block.Block getRelative(BlockFace blockFace, int i) {
        return null;
    }

    @Override
    public Material getType() {
        return type;
    }
    @Deprecated
    public int getTypeId() {
        return 0;
    }


    public byte getLightLevel() {
        return 0;
    }


    public byte getLightFromSky() {
        return 0;
    }


    public byte getLightFromBlocks() {
        return 0;
    }

    @Override
    public World getWorld() {
        return location.getWorld();
    }

    @Override
    public int getX() {
        return location.getBlockX();
    }

    @Override
    public int getY() {
        return location.getBlockY();
    }

    @Override
    public int getZ() {
        return location.getBlockZ();
    }

    @Override
    public Location getLocation() {
        return location;
    }


    public Location getLocation(Location location) {
        return null;
    }

    @Override
    public Chunk getChunk() {
        return location.getChunk();
    }


    public void setData(byte b) {

    }


    public void setData(byte b, boolean b1) {

    }

    @Override
    public void setType(Material material) {
        type = material;
    }


    public void setType(Material material, boolean b) {

    }


    public boolean setTypeId(int i) {
        return false;
    }


    public boolean setTypeId(int i, boolean b) {
        return false;
    }


    public boolean setTypeIdAndData(int i, byte b, boolean b1) {
        return false;
    }


    public BlockFace getFace(org.bukkit.block.Block block) {
        return null;
    }


    public BlockState getState() {
        return state;
    }

    @Override
    public Biome getBiome() {
        return location.getBlock().getBiome();
    }


    public void setBiome(Biome biome) {

    }


    public boolean isBlockPowered() {
        return false;
    }


    public boolean isBlockIndirectlyPowered() {
        return false;
    }


    public boolean isBlockFacePowered(BlockFace blockFace) {
        return false;
    }


    public boolean isBlockFaceIndirectlyPowered(BlockFace blockFace) {
        return false;
    }


    public int getBlockPower(BlockFace blockFace) {
        return 0;
    }


    public int getBlockPower() {
        return 0;
    }


    public boolean isEmpty() {
        return false;
    }


    public boolean isLiquid() {
        return false;
    }


    public double getTemperature() {
        return 0;
    }


    public double getHumidity() {
        return 0;
    }


    public PistonMoveReaction getPistonMoveReaction() {
        return null;
    }


    public boolean breakNaturally() {
        return false;
    }


    public boolean breakNaturally(ItemStack itemStack) {
        return false;
    }


    public Collection<ItemStack> getDrops() {
        return null;
    }


    public Collection<ItemStack> getDrops(ItemStack itemStack) {
        return null;
    }


    public void setMetadata(String s, MetadataValue metadataValue) {

    }


    public List<MetadataValue> getMetadata(String s) {
        return null;
    }


    public boolean hasMetadata(String s) {
        return false;
    }


    public void removeMetadata(String s, Plugin plugin) {

    }
}
