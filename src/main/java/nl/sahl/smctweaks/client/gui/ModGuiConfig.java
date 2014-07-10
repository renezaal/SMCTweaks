package nl.sahl.smctweaks.client.gui;

import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import nl.sahl.smctweaks.handler.ConfigurationHandler;
import nl.sahl.smctweaks.reference.Reference;

public class ModGuiConfig extends GuiConfig
{
    public ModGuiConfig(GuiScreen guiScreen)
    {
        super(
                guiScreen,
                new ConfigElement(ConfigurationHandler.configuration.getCategory(Reference.MAIN_CONFIG_CATEGORY)).getChildElements(),
                Reference.MOD_ID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
    }
}
