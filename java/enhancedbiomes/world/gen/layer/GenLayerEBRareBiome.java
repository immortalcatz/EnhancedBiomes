package enhancedbiomes.world.gen.layer;

import net.minecraft.world.biome.BiomeGenBase;
import static enhancedbiomes.world.biome.EnhancedBiomesArchipelago.*;
import static enhancedbiomes.world.biome.EnhancedBiomesBiome.*;
import static enhancedbiomes.world.biome.EnhancedBiomesGrass.*;
import static enhancedbiomes.world.biome.EnhancedBiomesPlains.*;
import static enhancedbiomes.world.biome.EnhancedBiomesRock.*;
import static enhancedbiomes.world.biome.EnhancedBiomesSand.*;
import static enhancedbiomes.world.biome.EnhancedBiomesSandstone.*;
import static enhancedbiomes.world.biome.EnhancedBiomesSnow.*;
import static enhancedbiomes.world.biome.EnhancedBiomesSnowForest.*;
import static enhancedbiomes.world.biome.EnhancedBiomesTropical.*;
import static enhancedbiomes.world.biome.EnhancedBiomesWetland.*;
import static enhancedbiomes.world.biome.EnhancedBiomesWoodland.*;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerEBRareBiome extends GenLayer
{
	public GenLayerEBRareBiome(long p_i45478_1_, GenLayer p_i45478_3_) {
		super(p_i45478_1_);
		this.parent = p_i45478_3_;
	}

	/**
	 * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall amounts, or biomeList[] indices based on the particular GenLayer subclass.
	 */
	public int[] getInts(int par1, int par2, int par3, int par4) {
		int[] aint = this.parent.getInts(par1 - 1, par2 - 1, par3 + 2, par4 + 2);
		int[] aint1 = IntCache.getIntCache(par3 * par4);

		for(int i1 = 0; i1 < par4; ++i1) {
			for(int j1 = 0; j1 < par3; ++j1) {
				this.initChunkSeed((long) (j1 + par1), (long) (i1 + par2));
				int k1 = aint[j1 + 1 + (i1 + 1) * (par3 + 2)];

				if(this.nextInt(57) == 0) {
					if(k1 == BiomeGenBase.plains.biomeID) {
						aint1[j1 + i1 * par3] = BiomeGenBase.plains.biomeID + 128;
					}

					else {
						aint1[j1 + i1 * par3] = k1;
					}
				}
				else {
					aint1[j1 + i1 * par3] = k1;
				}
			}
		}

		return aint1;
	}
}