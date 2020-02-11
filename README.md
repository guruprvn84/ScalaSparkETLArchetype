# ScalaSparkETLArchetype
A project template that advocates standards around coding and design of ETL apps based on Spark/Scala


# Intro:

Apache Spark has become an indispensable framework in Big data/AI and ML world. The data industry has made several leaps of advancements in data processing resulting in faster analytics, model evaluation and  . 
In spite of such advancements and immeasurable adoption of Spark its often noticed that the standards of implementation and application design always take a back seat. This is acceptable to some extent while building models but personally I think there is no reason to build ETL or analytic applications that are devoid of standards and design principles.
Right from my early days of Spark exploration (viz. 0.9 version) till date I have had very few occasions of stumbling upon good design with proper standards while building Scala/Spark application at least those considering that are available in public domain. Perhaps am unfortunate not to find such.
Following article is the outcome of my perceived lacuna in this space. Scala-Spark ETL Archetype is a project template that advocates standards around coding and design of ETL apps based on Spark/Scala. 

The rationale behind coming up with this Archetype is to address some of the key challenges that developers particularly newbies to Spark application design need to accept and resolve during the Spark journey and also to mitigate typical mistakes committed during early learning and adoption phases.

Challenges: 

1)	***Steep Learning curve*** : 
                      It’s very evident that based on the demography of Spark developers many are new to either Scala/Python as a programming language and few have had opportunity to work on concrete and complete spark application.

2)	***Influence*** : Considering that many of the developers had very few opportunities to work on Spark/Scala and indeed many are starting with it, the design and coding standards get heavily influenced by the developer background. Usually sql developers tend to write complete workflow in just a file, people with scripting background tend to have Unix scripts driving lot of the flow.  Such implementation tend to be standalone and are not open for extensions or improvisations and can attract huge maintenance.

3)	***Adherence to Standards*** : With the typical Supply-demand problem for Spark developers, companies have to either relax or sometimes forfeit hiring standards to have immediate onboarding and faster product roll outs. It’s obvious that teams would be built involving individuals with various backgrounds, it's very important to agree upon on common standards and framework at the outset

4)	***Cleaner and Faster Adoption*** : One of the common approaches while starting with Spark adoption is to port the queries (usually HQL/SQL ) as is. Though it’s not clean and suboptimal at times it might work but such design will never be able to utilise spark features in its full potential. 

    On the other hand many a times teams are expected to deliver quick even forfeiting quality. It’s very important for teams to accelerate early and reduce the inertia due to uncertainties during the early days

5)	***Transition and Maintenance*** : With proper standards set, teams would have less maintenance overhead and smooth transitions if any.


# Benefits

1) ***Takes care of*** 
                      
                      • Maven dependencies
                      • Configuration
                      • Spark IO 
                      • Logging
                      • Workflow component invocation
                      • Skeleton for complete workflow
2) ***Catalyses Spark Adoption*** : Considering that many developers are going through the learning curve, having this structure/ template would help them to focus on the core implementation and            forget about project setup, configurations, spark session management, log management and most importantly it gives them hooks to plug in their workflow specific code.
3) ***Centralized boiler plate code*** : The template is built keeping in mind to unload the burden of setting up project, dependency management, thinking of design principles, log management and configurations, the template takes care of these boiler plate code and reduces repetition of the code
4) ***Deduplication*** : Adoption of one project structure would enforce better standards and avoid re-invent the wheel scenarios. As Scala runs on JVM we need to be mindful of StringPool usage, GC etc. With constants file taking care of column names, table names, queries we could cut down duplication.
5) ***Head start for Developers*** : I think even for hands on Scala/spark developer this template should give at least a week head start and for learners it helps to build on their basic understanding and to quickly get into implementation
6) ***Smooth transition*** : With one project structure its easy to understand the code not just that the communication could be very effective considering the generic standards
7) ***Break silos*** : It should also help us to get the best from every team and am sure this template has more changes to go through and to become even more robust.


***Please refer to ScalaSparkETLArchetype.docx available under root for more information on Design, Adoption guide.***

