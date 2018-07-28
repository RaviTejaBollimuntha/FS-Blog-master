package me.zbl.fullstack.entity.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Bulk operation on the primary key package.
 *
 * @author raviteja
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TableKeyModel {

  private List<Integer> ids;
}
