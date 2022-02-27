package com.aimanissa.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = UserGoalEntity.TABLE_NAME,
    foreignKeys = [
        ForeignKey(
            entity = HabitsRosterEntity::class,
            parentColumns = [HabitsRosterEntity.ROSTER_ID],
            childColumns = [UserGoalEntity.ROSTER_CREATOR_ID],
            onDelete = CASCADE,
            deferred = true
        )
    ],
    indices = [
        Index(UserGoalEntity.ROSTER_CREATOR_ID)
    ]
)
data class UserGoalEntity(

    @PrimaryKey()
    @ColumnInfo(name = GOAL_ID)
    val goalId: Long,

    @ColumnInfo(name = ROSTER_CREATOR_ID)
    var rosterCreatorId: Long,

    @ColumnInfo(name = NAME)
    val name: String,

    @ColumnInfo(name = IS_DONE)
    val isDone: Boolean
) {

    companion object {

        const val TABLE_NAME = "user_goal"

        const val GOAL_ID = "goal_id"
        const val ROSTER_CREATOR_ID = "roster_creator_id"
        const val NAME = "name"
        const val IS_DONE = "is_done"
    }
}
