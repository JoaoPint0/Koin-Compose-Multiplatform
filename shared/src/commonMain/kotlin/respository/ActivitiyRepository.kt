package respository


class ActivityRepository() {

    private var count = 0

    suspend fun getCount() = count

    suspend fun increaseCount() {
        count++
    }
}
