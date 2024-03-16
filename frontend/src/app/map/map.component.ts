import { Component, NgZone } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { LeafletModule } from '@asymmetrik/ngx-leaflet';
import { MapOptions, Marker, divIcon, marker, tileLayer } from 'leaflet';

@Component({
  selector: 'app-map',
  standalone: true,
  imports: [LeafletModule, RouterModule],
  templateUrl: './map.component.html',
  styleUrl: './map.component.scss'
})
export class MapComponent {
  options: MapOptions = {
    layers: [
      tileLayer('https://{s}.google.com/vt/lyrs=s&x={x}&y={y}&z={z}', {
        subdomains: ['mt0', 'mt1', 'mt2', 'mt3'],
        maxZoom: 17,
        minZoom: 15,
        attribution: 'Google Maps'
      }),
    ],
    zoom: 15,
    center: [46.248217419483886, 20.150151671083876]
  };

  markers: Marker[] = [];

  constructor(private router: Router, private ngZone: NgZone) { }

  ngOnInit(): void {
    this.options.layers?.push(
      marker([46.25709056339844, 20.140673679569595], {
        icon: divIcon({
          html: `<img class="image" alt="Mars-tér" src="../../assets/images/marster.jpg"/>
                   <div class="tooltip">Mars-tér</div>`,
          className: 'custom-marker',
          iconSize: [64, 64],
          iconAnchor: [16, 32],
        })
    }).on('click', () => this.ngZone.run(() => this.router.navigateByUrl('/'))));
    this.options.layers?.push(
      marker([46.252027, 20.139124], {
        icon: divIcon({
          html: `<img class="image" alt="Négylépcsős söröző" src="../../assets/images/negylepcsos.jpeg"/>
                   <div class="tooltip">Négylépcsős söröző</div>`,
          iconSize: [64, 64],
          iconAnchor: [16, 32],
        })
    }).on('click', () => this.ngZone.run(() => this.router.navigateByUrl('/'))));
  }
}
