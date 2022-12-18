package net.alwayshak.notes;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class NotesCMD
        implements TabExecutor {
    private final NotesGUI notesGUI;

    public NotesCMD(NotesGUI notesGUI) {
        this.notesGUI = notesGUI;
    }

    public boolean onCommand(CommandSender s, Command cmd, String arg, String[] args) {
        if (s instanceof Player && (
                (Player) s).getGameMode() != GameMode.SPECTATOR) {
            if (args.length > 0) {
                String fstr = "";
                for (String str : args) {
                    fstr = fstr + fstr + " ";
                }
                Note.addNote((Player) s, fstr.strip(), this.notesGUI);
            } else {
                this.notesGUI.openChooseGUI((Player) s);
            }
        }

        return true;
    }

    public List<String> onTabComplete(CommandSender s, Command cmd, String arg, String[] argss) {
        return new ArrayList<>();
    }
}


