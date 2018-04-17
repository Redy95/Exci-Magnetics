package exci.magnetics;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid = "eximag", name = "Exci Magnetics", version = "0.1.1")
public class ExciMagnetics {
	
	public static Item itemMagnet;
	public static Item itemMagnet_Red;
	public static Item itemMagnet_Blue_Red;
	public static Item itemMagnetite;
	public static Block blockMagnetiteOre;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		//Item/Block init and registering
		//Config handling
		itemMagnet = new ItemMagnet().setUnlocalizedName("ItemMagnet").setTextureName("eximag:itemMagnet_White").setCreativeTab(tabExciMagnetic);
		itemMagnet_Red = new ItemMagnet_Red().setUnlocalizedName("ItemMagnet_Red").setTextureName("eximag:ItemMagnet_Red").setCreativeTab(tabExciMagnetic);
		itemMagnet_Blue_Red = new itemMagnet_Blue_Red().setUnlocalizedName("itemMagnet_Blue_Red").setTextureName("eximag:ItemMagnet_Blue_Red").setCreativeTab(tabExciMagnetic);
		itemMagnetite = new ItemMagnetite().setUnlocalizedName("ItemMagnetite").setTextureName("eximag:itemMagnetitePolished").setCreativeTab(tabExciMagnetic);
		blockMagnetiteOre = new blockMagnetiteOre(Material.rock).setBlockName("BlockMagnetiteOre").setBlockTextureName("eximag:blockmagnetiteore").setCreativeTab(tabExciMagnetic);
		
		GameRegistry.registerItem(itemMagnet, itemMagnet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemMagnet_Red, itemMagnet_Red.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemMagnet_Blue_Red, itemMagnet_Blue_Red.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemMagnetite, itemMagnetite.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(blockMagnetiteOre, blockMagnetiteOre.getUnlocalizedName().substring(5));
		System.out.println(blockMagnetiteOre.getUnlocalizedName().substring(5));
		
		GameRegistry.registerWorldGenerator(new MagnetiteGeneration(), 0);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		//Proxy, TileEntity, entity, GUI and Packet Registering
		GameRegistry.addRecipe(new ItemStack(itemMagnet), new Object[]{"M M","M M"," M ", 'M', itemMagnetite});
		GameRegistry.addRecipe(new ItemStack(itemMagnet_Red), new Object[]{"M M","M M","RMR",'M', itemMagnetite, 'R', new ItemStack(Items.dye, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(itemMagnet_Blue_Red), new Object[]{"M M","M M","BMR",'M', itemMagnetite, 'B', new ItemStack(Items.dye, 1, 4), 'R', new ItemStack(Items.dye, 1, 1)});
		GameRegistry.addSmelting(blockMagnetiteOre, new ItemStack (itemMagnetite), 15.0F);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
	public static CreativeTabs tabExciMagnetic = new CreativeTabs("tabExciMagnetic") {
		@Override
		public Item getTabIconItem() {
			return new ItemStack(itemMagnet).getItem();
		}
	};
}