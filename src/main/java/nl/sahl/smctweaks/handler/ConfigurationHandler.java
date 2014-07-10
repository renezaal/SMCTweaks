package nl.sahl.smctweaks.handler;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import nl.sahl.smctweaks.reference.Reference;

import java.io.File;

public class ConfigurationHandler
{

    public static Configuration configuration;

    // Configurable values
    public static boolean alphaFireSpread = true;
    public static boolean farmlandNeedsSky = true;
    public static boolean simplePhysicsEnabled = true;
    public static boolean plantsNeedSky = true;

    public static void init(File configFile)
    {
        // Create the configuration object from the configuration file
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
        }

        loadConfiguration();

    }

    private static void loadConfiguration()
    {
        // Read in the properties from the configuration file
        alphaFireSpread = configuration.get(Reference.MAIN_CONFIG_CATEGORY, "alphaFireSpread", false, "Make fire spread infinitely again").getBoolean(false);
        simplePhysicsEnabled = configuration.get(Reference.MAIN_CONFIG_CATEGORY, "simplePhysics", false, "Weak blocks will fall without proper support").getBoolean(false);
        farmlandNeedsSky = configuration.get(Reference.MAIN_CONFIG_CATEGORY, "farmLandNeedsSky", false, "Make farmland revert to dirt if it has no access to the sky").getBoolean(false);
        plantsNeedSky = configuration.get(Reference.MAIN_CONFIG_CATEGORY, "plantsNeedSky", false, "Prevent plants from growing if they have no access to the sky.\nThis does not apply to mushrooms or plants from mods").getBoolean(false);

        //Save the configuration file
        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            // Resync configs
            loadConfiguration();
        }
    }
}
