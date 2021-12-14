# fake-observation-gen
Simple test application for generating REST requests.
***
Genereerib REST-POST JSON formaadis päringuid.

Saadab konfiguratsioonis näidatud intervalli (msg-gen.scheduler.interval-in-ms) tagant HTTP POST päringuid näidatud aadressile (msg-gathering-server.url).   

Testimiseks on REST sõnumeid vastuvõtev teenus realiseeritud ka siin adapteris (endpoint: localconsumer/).

### Sõnumi näidis:
```json
{
  "id": "75d1c024-a528-4553-aa68-249c78b0615d",
  "timestamp": "2021-12-14T02:15:02+02:00",
  "level": "SECRET",
  "senderCode":"OBSERVER-ONE",
  "coordLat": 58.82658,
  "coordLon": 23.6552,
  "message": "Some SECRET level message"
}
```