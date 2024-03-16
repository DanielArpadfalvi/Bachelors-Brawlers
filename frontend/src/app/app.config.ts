import { ApplicationConfig, importProvidersFrom } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideHttpClient } from '@angular/common/http';

import { routes } from './app.routes';
import { LeafletModule } from '@asymmetrik/ngx-leaflet';

export const appConfig: ApplicationConfig = {
  providers: [
    importProvidersFrom(LeafletModule),
    provideRouter(routes), provideHttpClient()
  ]
};
