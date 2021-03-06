/*
 * Copyright (c) 2019 OBiBa. All rights reserved.
 *
 * This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.obiba.agate.web.model;

import org.obiba.agate.domain.Group;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
@SuppressWarnings("StaticMethodOnlyUsedInOneClass")
class GroupDtos {

  @NotNull
  Agate.GroupDto.Builder asBuilderDto(@NotNull Group group) {
    Agate.GroupDto.Builder builder = Agate.GroupDto.newBuilder();
    builder.setId(group.getId()) //
        .setName(group.getName()) //
        .setTimestamps(TimestampsDtos.asDto(group));

    if(group.hasDescription()) builder.setDescription(group.getDescription());

    builder.addAllApplications(group.getApplications());

    return builder;
  }

  @NotNull
  Group fromDto(@NotNull Agate.GroupDto dto) {
    Group group = new Group(dto.getName());

    if(dto.hasDescription()) group.setDescription(dto.getDescription());

    dto.getApplicationsList().forEach(a -> group.addApplication(a));

    return group;
  }
}
