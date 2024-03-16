import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-fight',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './fight.component.html',
  styleUrls: ['./fight.component.scss', '../app.component.scss']
})

export class FightComponent {
  battleLog: string[] = [];

  player: Character = {
    name: "Player Name",
    imageUrl: "https://w7.pngwing.com/pngs/835/401/png-transparent-shakes-and-fidget-shakes-fidget-comics-playa-games-gmbh-shakes-and-fidget-game-video-game-cartoon.png",
    attributes: {
      endurance: 80,
      loyalty: 90,
      intelligence: 70,
      agility: 85,
      luck: 75
    },
    healthPoints: 500,
    maxHealthPoints: 1000  
  };

  enemy: Character = {
    name: "Enemy Name",
    imageUrl: "https://w7.pngwing.com/pngs/1014/95/png-transparent-shakes-and-fidget-one-piece-pirate-warriors-3-shakes-fidget-hyrule-warriors-playa-games-shakes-and-fidget-classic-comics-video-game-fictional-character.png",
    attributes: {
      endurance: 75,
      loyalty: 80,
      intelligence: 65,
      agility: 75,
      luck: 70
    },
    healthPoints: 100,
    maxHealthPoints: 1000  
  };

  getHealthBarColor(healthPoints: number, maxHealthPoints: number): string {
    const percentage = (healthPoints / maxHealthPoints) * 100;

    if (percentage <= 20) {
      return 'red';
    } else if (percentage <= 60) {
      return 'yellow';
    } else {
      return 'green';
    }
  }

  startFight(): void {
  }
}

interface Character {
  name: string;
  imageUrl: string;
  attributes: {
    endurance: number;
    loyalty: number;
    intelligence: number;
    agility: number;
    luck: number;
  },
  healthPoints: number;
  maxHealthPoints: number;  
}
