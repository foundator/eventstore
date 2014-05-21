return {
    $view: function(state, views) {
        return state.ageSum == 0 ? 0 : state.ageSum / state.userCount;
    }
    $initial: function() {
        return {
            ageSum: 0,
            userCount: 0
        };
    },
    CreateUser: function(state, event) {
        state.ageSum += event.age;
        state.userCount += 1;
    }
};






return {
    $view: function(state, views) {
        return views.usersCreated() - views.usersDeleted();
    }
};
