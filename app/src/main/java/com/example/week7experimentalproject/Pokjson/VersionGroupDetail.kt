package com.example.week7experimentalproject.Pokjson

import com.example.week7experimentalproject.Pokjson.MoveLearnMethod
import com.example.week7experimentalproject.Pokjson.VersionGroup

data class VersionGroupDetail(
    val level_learned_at: Int,
    val move_learn_method: MoveLearnMethod,
    val version_group: VersionGroup
)