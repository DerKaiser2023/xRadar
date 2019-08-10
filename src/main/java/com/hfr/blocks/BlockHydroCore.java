package com.hfr.blocks;

import com.hfr.lib.RefStrings;
import com.hfr.main.MainRegistry;
import com.hfr.tileentity.TileEntityHydro;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockHydroCore extends BlockTurbine {

	protected BlockHydroCore(Material p_i45394_1_) {
		super(p_i45394_1_);
		this.isBlockContainer = true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.iconSide = iconRegister.registerIcon(RefStrings.MODID + ":hydro_port");
		this.blockIcon = iconRegister.registerIcon(RefStrings.MODID + ":hydro_wall");
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityHydro();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(world.isRemote)
		{
			return true;
		} else if(!player.isSneaking())
		{
			FMLNetworkHandler.openGui(player, MainRegistry.instance, ModBlocks.guiID_hydro, world, x, y, z);
			return true;
		} else {
			return true;
		}
	}

}
