package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < capacity) {
            this.roster.add(player);
        }
    }


    public boolean removePlayer(String name) {
        return this.roster.removeIf(p -> p.getName().equals(name));
    }

    public void promotePlayer(String name) {
        this.roster.stream().filter(p -> p.getName().equals(name)).limit(1).forEach(p -> p.setRank("Member"));
    }

    public void demotePlayer(String name) {
        this.roster.stream().filter(p -> p.getName().equals(name)).limit(1).forEach(p -> p.setRank("Trial"));
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> playersToKick = this.roster.stream().filter(p -> p.getClazz().equals(clazz)).collect(Collectors.toList());

        Player[] kickedPlayers = new Player[playersToKick.size()];
        playersToKick.toArray(kickedPlayers);

        this.roster.removeIf(p -> p.getClazz().equals(clazz));
        return kickedPlayers;
    }

    public int count() {
        return this.roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("Players in the guild: ").append(this.name).append(":").append(System.lineSeparator());
        if (!this.roster.isEmpty()) {
            for (Player player : this.roster) {
                sb.append(player.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
