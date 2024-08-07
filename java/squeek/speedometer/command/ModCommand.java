package squeek.speedometer.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import squeek.speedometer.ModSpeedometer;

import java.util.List;

public class ModCommand extends CommandBase {
    private final ModSpeedometer modSpeedometer;
    public ModCommand(ModSpeedometer modSpeedometer) {
        this.modSpeedometer = modSpeedometer;
    }


    @Override
    public String getCommandName() {
        return "sm";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + this.getCommandName();
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true; // return true otherwise you won't be able to use the command
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("reset")) {
            modSpeedometer.hudSpeedometer.resetAverage();
        }
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        // when you type the command and press tab complete,
        // this method will allow you to cycle through the words that match what you typed
        final String[] options = new String[]{"reset"};
        return getListOfStringsMatchingLastWord(args, options);
    }

}