package net.minecraft.src;

// MCPatcher Start
import com.pclewis.mcpatcher.mod.TileSize;
// MCPatcher End

public class TextureLavaFlowFX extends TextureFX {
	// MCPatcher Start
	protected float[] field_76871_g;
	protected float[] field_76874_h;
	protected float[] field_76875_i;
	protected float[] field_76872_j;
	int field_76873_k;
	// MCPatcher End

	public TextureLavaFlowFX() {
		super(Block.lavaMoving.blockIndexInTexture + 1);
		// MCPatcher Start
		this.field_76871_g = new float[TileSize.int_numPixels];
		this.field_76874_h = new float[TileSize.int_numPixels];
		this.field_76875_i = new float[TileSize.int_numPixels];
		this.field_76872_j = new float[TileSize.int_numPixels];
		this.field_76873_k = 0;
		// MCPatcher End
		this.tileSize = 2;
	}

	public void onTick() {
		++this.field_76873_k;
		int var2;
		float var3;
		int var5;
		int var6;
		int var7;
		int var8;
		int var9;

		// MCPatcher Start
		for (int var1 = 0; var1 < TileSize.int_size; ++var1) {
			for (var2 = 0; var2 < TileSize.int_size; ++var2) {
		// MCPatcher End
				var3 = 0.0F;
				int var4 = (int)(MathHelper.sin((float)var2 * (float)Math.PI * 2.0F / 16.0F) * 1.2F);
				var5 = (int)(MathHelper.sin((float)var1 * (float)Math.PI * 2.0F / 16.0F) * 1.2F);

				for (var6 = var1 - 1; var6 <= var1 + 1; ++var6) {
					for (var7 = var2 - 1; var7 <= var2 + 1; ++var7) {
						// MCPatcher Start
						var8 = var6 + var4 & TileSize.int_sizeMinus1;
						var9 = var7 + var5 & TileSize.int_sizeMinus1;
						var3 += this.field_76871_g[var8 + var9 * TileSize.int_size];
						// MCPatcher End
					}
				}

				// MCPatcher Start
				this.field_76874_h[var1 + var2 * TileSize.int_size] = var3 / 10.0F + (this.field_76875_i[(var1 + 0 & TileSize.int_sizeMinus1) + (var2 + 0 & TileSize.int_sizeMinus1) * TileSize.int_size] + this.field_76875_i[(var1 + 1 & TileSize.int_sizeMinus1) + (var2 + 0 & TileSize.int_sizeMinus1) * TileSize.int_size] + this.field_76875_i[(var1 + 1 & TileSize.int_sizeMinus1) + (var2 + 1 & TileSize.int_sizeMinus1) * TileSize.int_size] + this.field_76875_i[(var1 + 0 & TileSize.int_sizeMinus1) + (var2 + 1 & TileSize.int_sizeMinus1) * TileSize.int_size]) / 4.0F * 0.8F;
				this.field_76875_i[var1 + var2 * TileSize.int_size] += this.field_76872_j[var1 + var2 * TileSize.int_size] * 0.01F;

				if (this.field_76875_i[var1 + var2 * TileSize.int_size] < 0.0F) {
					this.field_76875_i[var1 + var2 * TileSize.int_size] = 0.0F;
				// MCPatcher End
				}

				// MCPatcher Start
				this.field_76872_j[var1 + var2 * TileSize.int_size] -= 0.06F;
				// MCPatcher End

				if (Math.random() < 0.005D) {
					// MCPatcher Start
					this.field_76872_j[var1 + var2 * TileSize.int_size] = 1.5F;
					// MCPatcher End
				}
			}
		}

		float[] var11 = this.field_76874_h;
		this.field_76874_h = this.field_76871_g;
		this.field_76871_g = var11;

		// MCPatcher Start
		for (var2 = 0; var2 < TileSize.int_numPixels; ++var2) {
			var3 = this.field_76871_g[var2 - this.field_76873_k / 3 * TileSize.int_size & TileSize.int_numPixelsMinus1] * 2.0F;
		// MCPatcher End

			if (var3 > 1.0F) {
				var3 = 1.0F;
			}

			if (var3 < 0.0F) {
				var3 = 0.0F;
			}

			var5 = (int)(var3 * 100.0F + 155.0F);
			var6 = (int)(var3 * var3 * 255.0F);
			var7 = (int)(var3 * var3 * var3 * var3 * 128.0F);

			if (this.anaglyphEnabled) {
				var8 = (var5 * 30 + var6 * 59 + var7 * 11) / 100;
				var9 = (var5 * 30 + var6 * 70) / 100;
				int var10 = (var5 * 30 + var7 * 70) / 100;
				var5 = var8;
				var6 = var9;
				var7 = var10;
			}

			this.imageData[var2 * 4 + 0] = (byte)var5;
			this.imageData[var2 * 4 + 1] = (byte)var6;
			this.imageData[var2 * 4 + 2] = (byte)var7;
			this.imageData[var2 * 4 + 3] = -1;
		}
	}
}
