## OuroborosUpdate
OuroborosUpdate is a library that aims to create a completely modular update system.

[![Quality Gate Status](https://sonar.th3shadowbroker.dev/api/project_badges/measure?project=org.th3shadowbroker.ouroboros.update%3AOuroborosUpdate&metric=alert_status)](https://sonar.th3shadowbroker.dev/dashboard?id=org.th3shadowbroker.ouroboros.update%3AOuroborosUpdate)
[![Maintainability Rating](https://sonar.th3shadowbroker.dev/api/project_badges/measure?project=org.th3shadowbroker.ouroboros.update%3AOuroborosUpdate&metric=sqale_rating)](https://sonar.th3shadowbroker.dev/dashboard?id=org.th3shadowbroker.ouroboros.update%3AOuroborosUpdate)
[![Vulnerabilities](https://sonar.th3shadowbroker.dev/api/project_badges/measure?project=org.th3shadowbroker.ouroboros.update%3AOuroborosUpdate&metric=vulnerabilities)](https://sonar.th3shadowbroker.dev/dashboard?id=org.th3shadowbroker.ouroboros.update%3AOuroborosUpdate)

### Maven dependency
```xml
<repositories>
  <!--Th3Shadowbroker-->
  <repository>
    <id>th3shadowbroker-snapshots</id>
    <url>https://nexus.m4taiori.io/repository/public/</url>
  </repository>
</repositories>

<dependencies>
  <dependency>
    <groupId>org.th3shadowbroker.ouroboros.update</groupId>
    <artifactId>core</artifactId>
    <version>VERSION</version>
  </dependency>
  
  <!-- Add the update module you want to use here! -->
  
</dependencies>
```

### Update modules
#### Spiget
Spiget is the #1 source for information on spigot plugins. Spiget is maintained by [inventivetalent](https://github.com/InventivetalentDev). A module for basic update notifications is part of this repository.
##### Maven dependency
```xml
<dependency>
  <groupId>org.th3shadowbroker.ouroboros.update</groupId>
  <artifactId>spiget</artifactId>
  <version>VERSION</version>
</dependency>
```
##### Example
```java
SpigetUpdater spigetUpdater = new SpigetUpdater(Comparator.SEMANTIC, this, 72325);
spigetUpdater.checkForUpdate();
```

### Contributing
OuroborosUpdate is licensed under the conditions of the MIT-License. Contributions in form of code or tips are always welcome.

### Reporting issues / Requesting features
Issue-reporting and feature-requests are an essential part of the libraries development. However, issues and requests that do not follow the issue templates might be rejected.

### Tips
Tips are always welcome and help me to keep my servers up and running or finance my development software.

[Sponsor me on GitHub](https://github.com/sponsors/Th3Shadowbroker)

[![](https://c5.patreon.com/external/logo/become_a_patron_button.png)](https://patreon.com/m4taiori)

[![](https://www.ko-fi.com/img/githubbutton_sm.svg)](https://ko-fi.com/O4O112IMF)
