# Android Architecture MVVM Kotlin Room Dagger2 + Hilt and Pagging 3

This example demonstrates MVVM architecture implementation in Android using different architecture components and DI frameworks like Dagger and Hilt. In its different branches, you will find the different implementations with different libraries and frameworks.

You'll find:
*   Kotlin **[Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)** for background operations.
*   The **[Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started)** to manage fragment operations.
*   MVVM architecture to separate presentation layer (View) and business logic (**ViewModel**)
*   Reactive UIs using **LiveData** observables and **Data Binding**.
*   A **data layer** with a repository and data sources.

## Variations

This project hosts different sample app in separate repository branches.

### Samples - Kotlin
|     Sample     | Description |
| ------------- | ------------- |
| [master](https://github.com/Pravin-Divraniya/mvvm-dagger-kotlin/tree/master) | A sample MVVM app that uses architecture components.<br/>Uses Kotlin, Architecture Components, Data Binding, Room, etc. Example follows SOLID principles and includes management of local and remote data through the DataManager class. |
| [feature-di-hilt](https://github.com/Pravin-Divraniya/mvvm-dagger-kotlin/tree/feature-di-hilt) | An application using MVVM architecture to demonstrate [paging 3 library](https://developer.android.com/topic/libraries/architecture/paging/v3-overview). API:- [rick and morty api](https://rickandmortyapi.com/). It uses Kotlin, Coroutines, LiveData, Retrofit, Navigation Components, Room for page caching, etc. Application display page from [network and database](https://developer.android.com/topic/libraries/architecture/paging/v3-network-db) using [RemoteMediator](https://developer.android.com/reference/kotlin/androidx/paging/RemoteMediator). For more information [check this](https://developer.android.com/topic/libraries/architecture/images/paging3-layered-architecture.svg). |
