mind-legal-neighbours-gatling
=============================

Gatling black box tests for my micro-service app. This app uses the Gatling-sbt plugin to add new commands to SBT. Run the micro-service first with `sbt run`, then run this project with `sbt gatling:test`.

[![Stories in Backlog](https://badge.waffle.io/scottkwalker/mind-legal-neighbours-gatling.png?label=backlog&title=Backlog)](http://waffle.io/scottkwalker/mind-legal-neighbours-gatling)

[![Stories in Ready](https://badge.waffle.io/scottkwalker/mind-legal-neighbours-gatling.png?label=ready&title=Ready)](http://waffle.io/scottkwalker/mind-legal-neighbours-gatling)

[![Stories In Progress](https://badge.waffle.io/scottkwalker/mind-legal-neighbours-gatling.png?label=In%20Progress&title=In%20Progress)](http://waffle.io/scottkwalker/mind-legal-neighbours-gatling)

Development prerequisites
-----------------------
1.  JDK 1.7.51 or 1.8 must be installed

2.  Install SBT.  The [current documentation][install-sbt] suggests:

    Mac: assuming homebrew is installed, `brew install sbt`

3.  If you are using Java 7 then you should increase the 'permanent generation space' requirements for SBT. Note: PermGen is managed automatically in Java 8.

    Mac: Create the file `~/.sbtconfig` with the following content:

        SBT_OPTS="-XX:+UseConcMarkSweepGC -XX:+CMSClassUnloadingEnabled -XX:PermSize=256M -XX:MaxPermSize=2048M"
        
Scott Walker
============
Hello! I'm a software developer based in London. I have a lot of experience working in Agile, TDD environments. I really enjoy functional programming and have put together this Scala application as a way to practice techniques.

A few of the big government projects ([Carer's Allowance](https://github.com/Department-for-Work-and-Pensions/ClaimCapture) and [DVLA](https://github.com/dvla)) are in the process of being regularly open sourced.

LinkedIn
--------
You can find out more about the other projects I've worked on through my [![View Scott Walker's profile on LinkedIn](https://static.licdn.com/scds/common/u/img/webpromo/btn_profile_greytxt_80x15.png)](http://uk.linkedin.com/in/scottwalkerlondon)

Stackoverflow
-------------
<a href="http://stackoverflow.com/users/2119533/scott-walker">
<img src="http://stackoverflow.com/users/flair/2119533.png?theme=clean" width="208" height="58" alt="profile for Scott Walker at Stack Overflow, Q&amp;A for professional and enthusiast programmers" title="profile for Scott Walker at Stack Overflow, Q&amp;A for professional and enthusiast programmers">
</a>
