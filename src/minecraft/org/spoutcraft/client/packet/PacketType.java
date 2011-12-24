/* This file is part of Spoutcraft (http://wiki.getspout.org/).
 * 
 * Spoutcraft is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Spoutcraft is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.spoutcraft.client.packet;

import java.util.HashMap;

public enum PacketType {
	PacketKeyPress(0, PacketKeyPress.class),
	PacketAirTime(1, PacketAirTime.class),
	PacketSkinURL(2, PacketSkinURL.class),
	PacketEntityTitle(3, PacketEntityTitle.class),
	//PacketPluginReload(4, PacketPluginReload.class),
	PacketRenderDistance(5, PacketRenderDistance.class),
	PacketAlert(6, PacketAlert.class),
	PacketPlaySound(7, PacketPlaySound.class),
	PacketDownloadMusic(8, PacketDownloadMusic.class),
	PacketClipboardText(9, PacketClipboardText.class),
	PacketMusicChange(10, PacketMusicChange.class),
	PacketWidget(11, PacketWidget.class),
	PacketStopMusic(12, PacketStopMusic.class),
	PacketItemName(13, PacketItemName.class),
	PacketSky(14, PacketSky.class),
	PacketTexturePack(15, PacketTexturePack.class),
	//PacketWorldSeed(16, PacketWorldSeed.class),
	PacketNotification(17, PacketNotification.class),
	PacketScreenAction(18, PacketScreenAction.class),
	PacketControlAction(19, PacketControlAction.class),
	PacketCacheHashUpdate(20, PacketCacheHashUpdate.class),
	PacketAllowVisualCheats(21, PacketAllowVisualCheats.class),
	PacketWidgetRemove(22, PacketWidgetRemove.class),
	PacketEntitySkin(23, PacketEntitySkin.class),
	PacketBiomeWeather(24, PacketBiomeWeather.class),
	PacketChunkRefresh(25, PacketChunkRefresh.class), 
	PacketOpenScreen(26, PacketOpenScreen.class),
	PacketPreCacheFile(27, PacketPreCacheFile.class),
	PacketCacheFile(28, PacketCacheFile.class),
	PacketCacheDeleteFile(29, PacketCacheDeleteFile.class),
	PacketPreCacheCompleted(30, PacketPreCacheCompleted.class),
	PacketMovementModifiers(31, PacketMovementModifiers.class),
	PacketSetVelocity(32, PacketSetVelocity.class),
	PacketFullVersion(33, PacketFullVersion.class),
	//PacketCustomId(34, PacketCustomId.class),
	//PacketItemTexture(35, PacketItemTexture.class),
	//PacketBlockHardness(36, PacketBlockHardness.class), 
	PacketOpenSignGUI(37, PacketOpenSignGUI.class),
	PacketCustomBlockOverride(38, PacketCustomBlockOverride.class),
	PacketCustomBlockDesign(39, PacketCustomBlockDesign.class),
	//PacketUniqueId(40, PacketUniqueId.class), 
	PacketKeyBinding(41, PacketKeyBinding.class),
	PacketBlockData(42, PacketBlockData.class),
	PacketCustomMultiBlockOverride(43, PacketCustomMultiBlockOverride.class),
	PacketServerPlugins(44, PacketServerPlugins.class),
	PacketAddonData(45, PacketAddonData.class),
	//PacketCustomMaterial(46, PacketCustomMaterial.class),
	PacketScreenshot(47, PacketScreenshot.class),
	PacketGenericItem(48, PacketGenericItem.class),
	PacketGenericTool(49, PacketGenericTool.class),
	PacketGenericBlock(50, PacketGenericBlock.class),
	PacketCustomBlockChunkOverride(51, PacketCustomBlockChunkOverride.class),
	PacketGenericFood(52, PacketGenericFood.class),
	PacketEntityInformation(53, PacketEntityInformation.class), 
	PacketComboBox(54, PacketComboBox.class),
	;
	
	private final int id;
	private final Class<? extends SpoutPacket> packetClass;
	private static final HashMap<Integer, PacketType> lookupId = new HashMap<Integer, PacketType>();
	PacketType(final int type, final Class<? extends SpoutPacket> packetClass) {
		this.id = type;
		this.packetClass = packetClass;
	}
	
	public int getId() {
		return id;
	}
	
	public Class<? extends SpoutPacket> getPacketClass() {
		return packetClass;
	}
	
	public static PacketType getPacketFromId(int id) {
		return lookupId.get(id);
	}
	
	
	static {
		for (PacketType packet : values()) {
			lookupId.put(packet.getId(), packet);
		}
	}
}
