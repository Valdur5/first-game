package de.pandigo.games.first.controller;

import de.pandigo.games.first.domain.client.MapClient;
import de.pandigo.games.first.domain.client.PlayerClient;
import de.pandigo.games.first.domain.entity.map.Position;
import de.pandigo.games.first.domain.type.CustomMediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller to control the player
 */
@RestController
@RequestMapping(value = "/player")
public class PlayerController {

    @Autowired
    private MapClient mapClient;

    @Autowired
    private PlayerClient playerClient;

    @RequestMapping(value = "/{playerId}", method = RequestMethod.POST, consumes = CustomMediaType.APPLICATION_MAP_OBJECTMOVETOPOSITION_JSON)
    public void movePlayerToPosition(@PathVariable(value = "playerId") final long playerId, @RequestBody() final Position position) {
        this.mapClient.moveObjectToPosition(playerId, position);
    }


}
