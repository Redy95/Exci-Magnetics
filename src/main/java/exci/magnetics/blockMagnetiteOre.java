package exci.magnetics;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class blockMagnetiteOre extends Block {

	protected blockMagnetiteOre(Material material) {
		super(material);
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(2.0F);
		this.setResistance(15F);
	}

}
